package com.example.cookpedia.ui.meal.domain.datasource

import android.util.Log
import com.example.cookpedia.ui.meal.data.DetailsMeal

fun splitInstructions(instructions: String?): MutableList<String> {
    val instructions1: MutableList<String> = instructions
        ?.split("\r\n")
        ?.filterNot { it.trim().isEmpty() || it.contains("STEP") }
        ?.toMutableList() ?: mutableListOf()
    return instructions1
}

fun getIngredientList(detailsMeal: DetailsMeal): List<String> {
    val ingredients = mutableListOf<String>()

    // Agrega cada ingrediente no nulo y no vacío a la lista
    detailsMeal.strIngredient1?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure1+": "+it.trim()) }
    detailsMeal.strIngredient2?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure2+": "+it.trim()) }
    detailsMeal.strIngredient3?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure3+": "+it.trim()) }
    detailsMeal.strIngredient4?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure4+": "+it.trim()) }
    detailsMeal.strIngredient5?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure5+": "+it.trim()) }
    detailsMeal.strIngredient6?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure6+": "+it.trim()) }
    detailsMeal.strIngredient7?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure7+": "+it.trim()) }
    detailsMeal.strIngredient8?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure8+": "+it.trim()) }
    detailsMeal.strIngredient9?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure9+": "+it.trim()) }
    detailsMeal.strIngredient10?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure10+": "+it.trim()) }
    detailsMeal.strIngredient11?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure11+": "+it.trim()) }
    detailsMeal.strIngredient12?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure12+": "+it.trim()) }
    detailsMeal.strIngredient13?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure13+": "+it.trim()) }
    detailsMeal.strIngredient14?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure14+": "+it.trim()) }
    detailsMeal.strIngredient15?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure15+": "+it.trim()) }
    detailsMeal.strIngredient16?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure16+": "+it.trim()) }
    detailsMeal.strIngredient17?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure17+": "+it.trim()) }
    detailsMeal.strIngredient18?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure18+": "+it.trim()) }
    detailsMeal.strIngredient19?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure19+": "+it.trim()) }
    detailsMeal.strIngredient20?.let { if (it.trim().isNotEmpty()) ingredients.add(detailsMeal.strMeasure20+": "+it.trim()) }

    return ingredients
}

