package acr.browser.lightning.browser.search

import acr.browser.lightning.R
import acr.browser.lightning.preference.UserPreferences
import acr.browser.lightning.utils.Utils
import acr.browser.lightning.utils.isSpecialUrl
import android.app.Application
import dagger.Reusable
import javax.inject.Inject

/**
 * A UI model for the search box.
 */
@Reusable
class SearchBoxModel @Inject constructor(
    private val userPreferences: UserPreferences,
    application: Application
) {

    private val untitledTitle: String = application.getString(R.string.untitled)

    fun getDisplayContent(url: String, title: String?, isLoading: Boolean): String =
        when {
            url == "file:///android_asset/index.html" -> "RS Browser"
            url.isSpecialUrl() -> ""
            isLoading -> url
            else -> when (userPreferences.urlBoxContentChoice) {
                SearchBoxDisplayChoice.DOMAIN -> safeDomain(url)
                SearchBoxDisplayChoice.URL -> url
                SearchBoxDisplayChoice.TITLE ->
                    if (title?.isEmpty() == false) {
                        title
                    } else {
                        untitledTitle
                    }
            }
        }

    private fun safeDomain(url: String) = Utils.getDisplayDomainName(url)

}
