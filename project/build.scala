import sbt._
import Keys._
import sbt.KeyRanks._
import sbtassembly.Plugin._
import com.ambiata.promulgate.project.ProjectPlugin._

object build extends Build {
  type Settings = Def.Setting[_]

  lazy val disorder = Project(
    id = "disorder"
  , base = file(".")
  , settings =
    Defaults.coreDefaultSettings ++
    Seq[Settings](
      name := "disorder"
    , version in ThisBuild := "0.0.1"
    , organization := "com.ambiata"
    , scalaVersion := "2.11.2"
    , crossScalaVersions := Seq("2.11.2")
    , libraryDependencies ++= depend.scalaz ++ depend.scalacheck ++ depend.specs2
    , depend.resolversSetting
    , scalacOptions ++= Seq(
        "-target:jvm-1.6"
      , "-deprecation"
      , "-unchecked"
      , "-feature"
      , "-language:_"
      , "-Xlint"
      , "-Xfatal-warnings"
      , "-Yinline-warnings"
      )
    , javacOptions ++= Seq("-source", "1.6", "-target", "1.6")
    ) ++ promulgate.library(s"com.ambiata.disorder", "ambiata-oss")
  )
}
