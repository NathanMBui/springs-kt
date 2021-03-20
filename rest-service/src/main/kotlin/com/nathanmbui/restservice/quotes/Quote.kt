package com.nathanmbui.restservice.quotes

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties
data class Quote(val type: String, val value: Value)
