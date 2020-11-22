package ru.skillbranch.skillarticles.ui.article

interface IArticleView {
    /**
     * отрисовать все вхождения поискового запрос в контент (spannable)
     */
    fun renderSearchResult(searchResult: List<Pair<Int, Int>>)

    /**
     * отрисовать текущее положения поиска и перевести фокус на него (spannable)
     */
    fun renderSearchPosition(searchPosition: Pair<Int, Int>?)

    /**
     * очистить результаты поиска (удалить все spannable)
     */
    fun clearSearchResult()

    /**
     * показать search bar
     */
    fun showSearchBar()
    /**
     * скрыть searchbar
     */
    fun hideSearchBar()
}