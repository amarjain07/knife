package `in`.amarjain.knife.utils

interface UrlProvider {
    fun base(): String
}

class KnifeUrlProvider(): UrlProvider {
    override fun base(): String = "https://serpapi.com/"
}