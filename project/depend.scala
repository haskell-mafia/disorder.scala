import sbt._
import Keys._

object depend {
  val scalaz     = Seq("org.scalaz"           %% "scalaz-core"     % "7.1.0",
                       "org.scalaz"           %% "scalaz-effect"   % "7.1.0")
  val scalacheck = Seq("org.scalacheck"       %% "scalacheck"      % "1.11.4")
  val specs2     = Seq("org.specs2"           %% "specs2-core"
                     , "org.specs2"           %% "specs2-scalacheck"
                     , "org.specs2"           %% "specs2-junit").map(_ % "2.4.5" % "test")

  val resolvers = Seq(
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots"),
      Resolver.sonatypeRepo("public"),
      Resolver.typesafeRepo("releases"),
      "cloudera"             at "https://repository.cloudera.com/content/repositories/releases",
      Resolver.url("ambiata-oss", new URL("https://ambiata-oss.s3.amazonaws.com"))(Resolver.ivyStylePatterns),
      "Scalaz Bintray Repo"  at "http://dl.bintray.com/scalaz/releases")
}
