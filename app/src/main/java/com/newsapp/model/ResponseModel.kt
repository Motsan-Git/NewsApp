package com.newsapp.model

class ResponseModel (
    var status:String,
    var totalResults:Int,
    var articles:List<News>
){
}