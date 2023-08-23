package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.CoffeeInfo
import com.example.mycity.model.District

object DataProvider {
    val defaultDistrict = getCoffeeData()[0]
    val defaultCoffee = getCoffeeData()[0].coffeeList[0]

    fun getCoffeeData(): List<District> {
        return listOf(
            District(
                1,
                districtResourceId = R.string.district_1,
                imageResourceId = R.drawable.quan1,
                coffeeList = listOf(
                    CoffeeInfo(
                        id = 1,
                        nameResourceId = R.string.beanthere_d1,
                        addressResourceId = R.string.beanthere_d1_address,
                        districtResourceId = R.string.district_1,
                        imageResourceId = R.drawable.beanthere_quan_ca_phe_quan_1,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 2,
                        nameResourceId = R.string.kohi_d1,
                        addressResourceId = R.string.kohi_d1_address,
                        districtResourceId = R.string.district_1,
                        imageResourceId = R.drawable.kohi_quan_cafe_quan_1,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 3,
                        nameResourceId = R.string.coma_d1,
                        addressResourceId = R.string.coma_d1_address,
                        districtResourceId = R.string.district_1,
                        imageResourceId = R.drawable.coma_quan_ca_phe_quan_1,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 4,
                        nameResourceId = R.string.little_hanoi_d1,
                        addressResourceId = R.string.little_hanoi_d1_address,
                        districtResourceId = R.string.district_1,
                        imageResourceId = R.drawable.little_hanoi_egg_quan_ca_phe_quan_1,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 5,
                        nameResourceId = R.string.cheese_d1,
                        addressResourceId = R.string.cheese_d1_address,
                        districtResourceId = R.string.district_1,
                        imageResourceId = R.drawable.cheese_coffee_quan_ca_phe_quan_1,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 6,
                        nameResourceId = R.string.paul_d1,
                        addressResourceId = R.string.paul_d1_address,
                        districtResourceId = R.string.district_1,
                        imageResourceId = R.drawable.cafe_paul__1932_quan_1,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                )
            ),
            District(
                2,
                districtResourceId = R.string.district_3,
                imageResourceId = R.drawable.quan3,
                coffeeList = listOf(
                    CoffeeInfo(
                        id = 1,
                        nameResourceId = R.string.opalm_d3,
                        addressResourceId = R.string.opalm_d3_address,
                        districtResourceId = R.string.district_3,
                        imageResourceId = R.drawable.quan_ca_phe_quan_3_o_palm_cafe,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 2,
                        nameResourceId = R.string.threeoclock_d3,
                        addressResourceId = R.string.threeoclock_d3_address,
                        districtResourceId = R.string.district_3,
                        imageResourceId = R.drawable.quan_ca_phe_quan_3_three_o_clock,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 3,
                        nameResourceId = R.string.seat_d3,
                        addressResourceId = R.string.seat_d3_address,
                        districtResourceId = R.string.district_3,
                        imageResourceId = R.drawable.quan_ca_phe_quan_3_seat_cafe,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 4,
                        nameResourceId = R.string.oz_d3,
                        addressResourceId = R.string.oz_d3_address,
                        districtResourceId = R.string.district_3,
                        imageResourceId = R.drawable.oz_quan3,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 5,
                        nameResourceId = R.string.xyz_d3,
                        addressResourceId = R.string.xyz_d3_address,
                        districtResourceId = R.string.district_3,
                        imageResourceId = R.drawable.quan_ca_phe_quan_3_xyz_cafe,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 6,
                        nameResourceId = R.string.anh_d3,
                        addressResourceId = R.string.anh_d3_address,
                        districtResourceId = R.string.district_3,
                        imageResourceId = R.drawable.quan_ca_phe_quan_3_anh_coffee,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                )
            ),
            District(
                3,
                districtResourceId = R.string.district_5,
                imageResourceId = R.drawable.quan5,
                coffeeList = listOf(
                    CoffeeInfo(
                        id = 1,
                        nameResourceId = R.string.lac_d5,
                        addressResourceId = R.string.lac_d5_address,
                        districtResourceId = R.string.district_5,
                        imageResourceId = R.drawable.lac_concept_2_quan_ca_phe_quan_5,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 2,
                        nameResourceId = R.string.september_d5,
                        addressResourceId = R.string.september_d5_address,
                        districtResourceId = R.string.district_5,
                        imageResourceId = R.drawable.september_quan_ca_phe_quan_5,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 3,
                        nameResourceId = R.string.danshari_d5,
                        addressResourceId = R.string.danshari_d5_address,
                        districtResourceId = R.string.district_5,
                        imageResourceId = R.drawable.danshari_1_quan_ca_phe_quan_5,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 4,
                        nameResourceId = R.string.rosieposie_d5,
                        addressResourceId = R.string.rosieposie_d5_address,
                        districtResourceId = R.string.district_5,
                        imageResourceId = R.drawable.rosie_posie_1_quan_ca_phe_quan_5,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 5,
                        nameResourceId = R.string.lucid_d5,
                        addressResourceId = R.string.lucid_d5_address,
                        districtResourceId = R.string.district_5,
                        imageResourceId = R.drawable.lucid_quan_ca_phe_quan_5,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 6,
                        nameResourceId = R.string.mof_d5,
                        addressResourceId = R.string.mof_d5_address,
                        districtResourceId = R.string.district_5,
                        imageResourceId = R.drawable.mof_quan5,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                )
            ),
            District(
                4,
                districtResourceId = R.string.thu_duc_city,
                imageResourceId = R.drawable.thuduc,
                coffeeList = listOf(
                    CoffeeInfo(
                        id = 1,
                        nameResourceId = R.string.vibes_td,
                        addressResourceId = R.string.vibes_td_address,
                        districtResourceId = R.string.thu_duc_city,
                        imageResourceId = R.drawable.the_vibes_1_thuduc,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 2,
                        nameResourceId = R.string.olin_td,
                        addressResourceId = R.string.olin_td_address,
                        districtResourceId = R.string.thu_duc_city,
                        imageResourceId = R.drawable.ollin_cafe_1_thuduc,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 3,
                        nameResourceId = R.string.dome_td,
                        addressResourceId = R.string.dome_td_address,
                        districtResourceId = R.string.thu_duc_city,
                        imageResourceId = R.drawable.dome_sai_gon_1_thuduc,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 4,
                        nameResourceId = R.string.logan_td,
                        addressResourceId = R.string.logan_td_address,
                        districtResourceId = R.string.thu_duc_city,
                        imageResourceId = R.drawable.logan_station_thuduc,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 5,
                        nameResourceId = R.string.rooftop_td,
                        addressResourceId = R.string.rooftop_td_address,
                        districtResourceId = R.string.thu_duc_city,
                        imageResourceId = R.drawable.ca_phe_may_chieu_rooftop_thuduc,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                    CoffeeInfo(
                        id = 6,
                        nameResourceId = R.string.elmar_td,
                        addressResourceId = R.string.elmar_td_address,
                        districtResourceId = R.string.thu_duc_city,
                        imageResourceId = R.drawable.elma_coffee_thuduc,
                        coffeeDetails = R.string.coffee_detail_text
                    ),
                )
            ),
        )
    }
}
