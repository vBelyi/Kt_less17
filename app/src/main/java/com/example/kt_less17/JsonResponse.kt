package com.example.kt_less17

data class GetResponse(
    var id: String,
    var name: String,
    var slug: String,
    var powerstats: Powerstats,
    var appearance: Appearance,
    var biography: Biography,
    var work: Work,
    var connections: Connections,
    var images: Images
)

data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Appearance(
    val gender: String,
    val race: String,
    val height: ArrayList<String> = arrayListOf(),
    val weight: ArrayList<String> = arrayListOf(),
    val eyeColor: String,
    val hairColor: String
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Connections(
    val groupAffiliation: String,
    val relatives: String
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)