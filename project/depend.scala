import ohnosequences.sbt.SbtS3Resolver.autoImport.{s3 => ss33, _}
import sbt._
import Keys._
import ohnosequences.sbt.SbtS3Resolver._
import com.amazonaws.services.s3.model.Region
import com.amazonaws.auth._, profile._

object depend {
  val scalaz     = Seq("org.scalaz"           %% "scalaz-core"     % "7.1.0",
                       "org.scalaz"           %% "scalaz-effect"   % "7.1.0")
  val scalacheck = Seq("org.scalacheck"       %% "scalacheck"      % "1.11.4")
  val specs2     = Seq("org.specs2"           %% "specs2-core"
                     , "org.specs2"           %% "specs2-scalacheck"
                     , "org.specs2"           %% "specs2-junit").map(_ % "2.4.5" % "test")

 def resolversSetting = resolvers ++=
    List( Resolver.sonatypeRepo("releases")
        , Resolver.sonatypeRepo("snapshots")
        , Resolver.sonatypeRepo("public")
        , Resolver.typesafeRepo("releases")
        ) ++
    List[Resolver](
      Resolver.url("ambiata-oss", new URL("https://ambiata-oss.s3.amazonaws.com"))(Resolver.ivyStylePatterns)
    , S3Resolver(
        new EnvironmentVariableCredentialsProvider() |
        new InstanceProfileCredentialsProvider()
      , false
      , Region.AP_Sydney
      , com.amazonaws.services.s3.model.CannedAccessControlList.BucketOwnerFullControl) ("ambiata-pay-read", ss33("ambiata-pay")).withIvyPatterns
    )
}
