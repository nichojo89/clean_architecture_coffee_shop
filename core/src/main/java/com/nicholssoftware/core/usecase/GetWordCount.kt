package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Note

class GetWordCount {
    operator fun invoke(note: Note) =
        getCount(note.title) + getCount(note.content)

    private fun getCount(str: String) =
        str.split(" ", "\n")
            .filter { it.contains(Regex(".*[a-zA-Z].*")) }
            .count()
}