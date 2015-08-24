package com.ambiata.disorder

trait Corpus {

  val languages =  List(
      "Agda"
    , "Axum"
    , "Batch"
    , "C"
    , "C#"
    , "C++"
    , "Cobol"
    , "Delphi"
    , "F#"
    , "Lisp"
    , "Hack"
    , "Haskell"
    , "Java"
    , "Julia"
    , "Python"
    , "R"
    , "Sed"
    , "WebQL"
    , "Zeno"
  )

  val descriptions = List(
      "Noob"
    , "Novice"
    , "Rookie"
    , "Beginner"
    , "Talented"
    , "Skilled"
    , "Intermediate"
    , "Skillful"
    , "Seasoned"
    , "Proficient"
    , "Experienced"
    , "Advanced"
    , "Senior"
    , "Expert"
  )

  val cooking = List(
    "salted"
  , "stewed"
  , "diced"
  , "filleted"
  , "sauteed"
  )

  val muppets = List(
    "kermit"
  , "gonzo"
  , "fozzy"
  , "chef"
  , "statler"
  , "waldorf"
  , "beaker"
  , "animal"
  )

  val southpark = List(
    "kyle"
  , "stan"
  , "cartman"
  , "timmy"
  , "token"
  , "chef"
  , "garrison"
  )


  val simpsons = List(
    "homer"
  , "marge"
  , "maggie"
  , "lisa"
  , "bart"
  , "flanders"
  , "moe"
  , "barney"
  )

  val viruses = List(
    "rotavirus"
  , "smallpox"
  , "norovirus"
  , "chickenpox"
  , "camelpox"
  , "dengue"
  , "echovirus"
  , "equine morbillivirus"
  , "gou virus"
  , "measles"
  , "monkeypox"
  )

  val colours = List(
    "red"
  , "green"
  , "blue"
  , "yellow"
  , "black"
  , "grey"
  , "purple"
  , "orange"
  , "pink"
  )

  val weather = List(
    "dry"
  , "raining"
  , "hot"
  , "humid"
  , "snowing"
  , "fresh"
  , "windy"
  , "freezing"
  )
}

object Corpus extends Corpus
