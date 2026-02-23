package acr.browser.lightning.utils

import acr.browser.lightning.preference.DeveloperPreferences
import javax.inject.Inject

/**
 * Sets up LeakCanary. (Removed)
 */
class LeakCanaryUtils @Inject constructor(private val developerPreferences: DeveloperPreferences) {

    /**
     * Setup LeakCanary
     */
    fun setup() {
        // LeakCanary ka code yahan se hamesha ke liye hata diya gaya hai
    }

}
