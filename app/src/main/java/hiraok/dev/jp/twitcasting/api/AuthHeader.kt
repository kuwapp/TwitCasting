package hiraok.dev.jp.twitcasting.api

import android.util.Base64
import hiraok.dev.jp.twitcasting.BuildConfig
import okhttp3.Headers

object AuthHeader {

    fun createHeader(accessToken: String? = null): Headers {
        val map = mapOf(Pair("X-Api-Version", "2.0"),
                Pair("Authorization", authorizationValue(accessToken)))
        return Headers.of(map)
    }

    private fun authorizationValue(accessToken: String?): String {
        return accessToken?.let { accessTokenValue(it) } ?: clientIdSecretValue()
    }

    private fun accessTokenValue(accessToken: String): String {
        return " Bearer " + accessToken;
    }

    private fun clientIdSecretValue(): String {
        return " Basic " + base64ClientIdSecret()
    }

    private fun base64ClientIdSecret(): String {
        val clientIdAndSecret = "chiraok.2d438d2efb56736aea7c282f6e1904b8244d707dff660a03c61c308aac814e82" + ":" + "f4075f9ef7e054ee7fa70817fa70af775924262202aa9e1294be33b992c17a49"
        return Base64.encodeToString(clientIdAndSecret.toByteArray(), Base64.NO_WRAP)
    }

}