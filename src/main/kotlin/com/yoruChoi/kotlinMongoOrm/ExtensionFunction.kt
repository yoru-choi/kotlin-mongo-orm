package com.yoruChoi.kotlinMongoOrm


fun String.snakeToCamel(): String {
    return this.split('_')
        .mapIndexed { index, word ->
            if (index == 0) word else word.replaceFirstChar { it.uppercase() }
        }.joinToString("")
}
