scalacOptions += "-deprecation"

resolvers += Resolver.url("ambiata-oss", new URL("https://ambiata-oss.s3.amazonaws.com"))(Resolver.ivyStylePatterns)

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.typesafeRepo("releases")

addSbtPlugin("com.ambiata" % "promulgate" % "0.11.0-20141014013725-80c129f")
