package com.vaishnav.flobiz.model

sealed class RecyclerViewData {
    class Ques(
        val owner: Owner? = null,
        val contentLicense: String? = null,
        val score: Int? = null,
        val link: String? = null,
        val lastActivityDate: Int? = null,
        val isAnswered: Boolean? = null,
        val creation_date: Long? = null,
        val answerCount: Int? = null,
        val title: String? = null,
        val questionId: Int? = null,
        val viewCount: Int? = null,
        val tags: List<String?>? = null,
        val closedDate: Int? = null,
        val closedReason: String? = null,
        val lastEditDate: Int? = null,
        val acceptedAnswerId: Int? = null
    ) : RecyclerViewData()

    class Ad(
        val imageLink : String
    ) : RecyclerViewData()
}