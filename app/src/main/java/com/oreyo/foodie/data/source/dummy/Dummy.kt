package com.oreyo.foodie.data.source.dummy

import com.oreyo.foodie.R
import com.oreyo.foodie.model.Category
import com.oreyo.foodie.model.TopUp
import com.oreyo.foodie.util.CategoryType

object Dummy {

    fun setCategories(): List<Category> {
        return listOf(
            Category(
                R.drawable.ic_category_all,
                CategoryType.All.title,
                CategoryType.All.type
            ),
            Category(
                R.drawable.ic_category_spicy,
                CategoryType.Spicy.title,
                CategoryType.Spicy.type
            ),
            Category(
                R.drawable.ic_category_drink,
                CategoryType.Drink.title,
                CategoryType.Drink.type
            ),
            Category(
                R.drawable.ic_category_rice,
                CategoryType.Rice.title,
                CategoryType.Rice.type
            ),
            Category(
                R.drawable.ic_category_vegetable,
                CategoryType.Vegetable.title,
                CategoryType.Vegetable.type
            ),
            Category(
                R.drawable.ic_category_snack,
                CategoryType.Snack.title,
                CategoryType.Snack.type
            ),
            Category(
                R.drawable.ic_category_meat,
                CategoryType.Meat.title,
                CategoryType.Meat.type
            ),
            Category(
                R.drawable.ic_category_street_food,
                CategoryType.StreetFood.title,
                CategoryType.StreetFood.type
            ),
            Category(
                R.drawable.ic_category_soup,
                CategoryType.Soup.title,
                CategoryType.Soup.type
            ),
            Category(
                R.drawable.ic_category_cake,
                CategoryType.Cake.title,
                CategoryType.Cake.type
            ),
        )
    }

    fun setTopUpPayment(): List<TopUp>{
        return listOf(
            TopUp("BCA",R.drawable.ic_logo_bca),
            TopUp("BNI",R.drawable.ic_logo_bni),
            TopUp("BRI",R.drawable.ic_logo_bri),
            TopUp("Dana",R.drawable.ic_logo_dana),
            TopUp("Gopay",R.drawable.ic_logo_gopay),
            TopUp("LinkAja",R.drawable.ic_logo_linkaja),
            TopUp("OVO",R.drawable.ic_logo_ovo),
        )
    }
}