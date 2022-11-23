package net.ormr.userskripter.example

import kotlinx.browser.document
import kotlinx.coroutines.launch
import net.ormr.userskripter.engine.greasemonkey.GreaseMonkey
import net.ormr.userskripter.engine.greasemonkey.notification
import net.ormr.userskripter.userskript
import net.ormr.userskripter.util.appendNewElement
import org.w3c.dom.HTMLButtonElement

fun main() = userskript {
    val element = document.querySelector("body > div")!!
    element.appendNewElement<HTMLButtonElement>("button") {
        textContent = "Click Me!"
        onclick = {
            launch {
                GreaseMonkey.notification {
                    text = "This is a notification!"
                }
            }
        }
    }
}