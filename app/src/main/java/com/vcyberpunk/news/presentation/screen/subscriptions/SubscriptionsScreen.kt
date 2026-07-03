package com.vcyberpunk.news.presentation.screen.subscriptions

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.vcyberpunk.news.R
import com.vcyberpunk.news.domain.entity.Article
import com.vcyberpunk.news.presentation.ui.theme.CustomIcons
import com.vcyberpunk.news.presentation.utils.formatDate

@Composable
fun SubscriptionsScreen(
    modifier: Modifier = Modifier,
    viewModel: SubscriptionViewModel = hiltViewModel(),
    onNavigateToSettings: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            SubscriptionsTopBar(
                onRefreshDataClick = { viewModel.processCommand(SubscriptionsCommand.RefreshData) },
                onClearArticlesClick = { viewModel.processCommand(SubscriptionsCommand.ClearArticles) },
                onSettingsClick = onNavigateToSettings
            )
        }
    ) { innerPadding ->
        val state by viewModel.state.collectAsStateWithLifecycle()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Subscriptions(
                    subscriptions = state.subscriptions,
                    query = state.query,
                    isSubscribedButtonEnabled = state.subscribeButtonEnabled,
                    onQueryChanged = {
                        viewModel.processCommand(SubscriptionsCommand.InputTopic(it))
                    },
                    onTopicClick = {
                        viewModel.processCommand(SubscriptionsCommand.ToggleTopicSelection(it))
                    },
                    onDeleteSubscriptions = {
                        viewModel.processCommand(SubscriptionsCommand.RemoveSubscription(it))
                    },
                    onSubscribeButtonClick = {
                        viewModel.processCommand(SubscriptionsCommand.ClickSubscribe)
                    }
                )
            }
            if (state.articles.isNotEmpty()) {
                item {
                    HorizontalDivider()
                }
                item {
                    Text(
                        text = stringResource(R.string.articles, state.articles.size),
                        fontWeight = FontWeight.Bold
                    )
                }
                item {
                    HorizontalDivider()
                }
                items(state.articles, key = { it.url }) {
                    ArticleCard(
                        article = it
                    )
                }
            } else if (state.subscriptions.isNotEmpty()) {
                item {
                    HorizontalDivider()
                }
                item {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.no_articles_for_selected_subscriptions),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubscriptionsTopBar(
    modifier: Modifier = Modifier,
    onRefreshDataClick: () -> Unit,
    onClearArticlesClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.subscriptions_title)
            )
        },
        actions = {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onRefreshDataClick()
                    }
                    .padding(8.dp),
                imageVector = CustomIcons.Refresh,
                contentDescription = stringResource(R.string.update_articles)
            )
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onClearArticlesClick()
                    }
                    .padding(8.dp),
                imageVector = CustomIcons.Clear,
                contentDescription = stringResource(R.string.clear_articles)
            )
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onSettingsClick()
                    }
                    .padding(8.dp),
                imageVector = CustomIcons.Settings,
                contentDescription = stringResource(R.string.settings_screen)
            )
        }
    )
}

@Composable
private fun SubscriptionChip(
    modifier: Modifier = Modifier,
    topic: String,
    isSelected: Boolean,
    onSubscriptionClick: (String) -> Unit,
    onDeleteSubscriptionClick: (String) -> Unit
) {
    FilterChip(
        modifier = modifier,
        selected = isSelected,
        onClick = {
            onSubscriptionClick(topic)
        },
        label = {
            Text(
                text = topic
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        onDeleteSubscriptionClick(topic)
                    },
                imageVector = CustomIcons.Clear,
                contentDescription = stringResource(R.string.remove_subscription)
            )
        }
    )
}

@Composable
private fun Subscriptions(
    modifier: Modifier = Modifier,
    subscriptions: Map<String, Boolean>,
    query: String,
    isSubscribedButtonEnabled: Boolean,
    onQueryChanged: (String) -> Unit,
    onTopicClick: (String) -> Unit,
    onDeleteSubscriptions: (String) -> Unit,
    onSubscribeButtonClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = query,
            onValueChange = onQueryChanged,
            label = {
                Text(stringResource(R.string.what_interests_you))
            },
            singleLine = true
        )

        Spacer(Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSubscribeButtonClick,
            enabled = isSubscribedButtonEnabled
        ) {
            Icon(
                imageVector = CustomIcons.Add,
                contentDescription = stringResource(R.string.add_subscription)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.add_subscription)
            )
        }

        Spacer(Modifier.height(16.dp))

        if (subscriptions.isNotEmpty()) {
            Text(
                text = stringResource(R.string.subscriptions, subscriptions.size),
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                subscriptions.forEach { (topic, isSelected) ->
                    item(key = topic) {
                        SubscriptionChip(
                            topic = topic,
                            isSelected = isSelected,
                            onSubscriptionClick = onTopicClick,
                            onDeleteSubscriptionClick = onDeleteSubscriptions
                        )
                    }
                }
            }
        } else {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.no_subscriptions),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun ArticleCard(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    article: Article
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        article.imageUrl?.let { imageUrl ->
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp),
                model = imageUrl,
                contentDescription = "Image for article ${article.title}",
                contentScale = ContentScale.FillWidth
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = article.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(8.dp))

        if (article.description.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = article.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.height(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = article.sourceName,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = article.publishedAt.formatDate(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )
        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    val uri = article.url.toUri()
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                }
            ) {
                Icon(
                    imageVector = CustomIcons.OpenInNew,
                    contentDescription = stringResource(R.string.read_article)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.read)
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "plain/text"
                        putExtra(Intent.EXTRA_TEXT, "${article.title}\n\n${article.url}")
                    }
                    context.startActivity(intent)
                }
            ) {
                Icon(
                    imageVector = CustomIcons.Share,
                    contentDescription = stringResource(R.string.share_article)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.share)
                )
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}