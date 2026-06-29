package com.vcyberpunk.news.data.mapper


import com.vcyberpunk.news.data.local.entity.ArticleDbModel
import com.vcyberpunk.news.data.remote.entity.NewsResponseDto
import com.vcyberpunk.news.domain.entity.Article
import java.text.SimpleDateFormat
import java.util.Locale

fun NewsResponseDto.toDbModels(topic: String): List<ArticleDbModel> {
    return articles.map { articleDto ->
        ArticleDbModel(
            title = articleDto.title,
            description = articleDto.description,
            imageUrl = articleDto.urlToImage,
            sourceName = articleDto.source.name,
            publishedAt = articleDto.publishedAt.toTimestamp(),
            url = articleDto.url,
            topic = topic
        )
    }
}

fun List<ArticleDbModel>.toEntities(): List<Article> = map { dbModel ->
    Article(
        title = dbModel.title,
        description = dbModel.description,
        imageUrl = dbModel.imageUrl,
        sourceName = dbModel.sourceName,
        publishedAt = dbModel.publishedAt,
        url = dbModel.url
    )
}.distinct()

private fun String.toTimestamp(): Long {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    return dateFormatter.parse(this)?.time ?: System.currentTimeMillis()
}