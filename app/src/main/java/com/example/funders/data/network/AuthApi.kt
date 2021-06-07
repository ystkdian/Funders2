package com.example.funders.data.network

import com.example.funders.data.responses.LoginResponse
import com.example.funders.data.responses.investor.Investor
import com.example.funders.data.responses.pengusaha.Pengusaha
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("api/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("api/auth/get_all_investor")
    fun getInvestors(
        @Field("alamat") alamat: String,
        @Field("email") email: String,
        @Field("id") id: Int,
        @Field("kategori") kategori: String,
        @Field("lokasi") lokasi: String,
        @Field("name") name: String,
        @Field("no_telp") no_telp: String,
        @Field("provinsi") provinsi: String,
        @Field("range_employee") range_employee: String,
        @Field("range_fund") range_fund: String,
        @Field("status") status: String
    ): Investor

    @GET("api/auth/get_all_pengusaha")
    fun getPengusaha(
        @Field("alamat") alamat: String,
        @Field("email") email: String,
        @Field("id") id: Int,
        @Field("kategori") kategori: String,
        @Field("lokasi") lokasi: String,
        @Field("name") name: String,
        @Field("no_telp") no_telp: String,
        @Field("provinsi") provinsi: String,
        @Field("range_employee") range_employee: String,
        @Field("range_fund") range_fund: String,
        @Field("status") status: String
    ): Pengusaha
}