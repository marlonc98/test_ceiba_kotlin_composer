package com.lamzentertainment.testceiba.data.local.repositories.user

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserLocalRepositoryTest {
    lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    suspend fun getUserInvalid() {
        val userLocalRepository = UserLocalRepository(instrumentationContext)
        val user = userLocalRepository.getUser(-1)
        assertNotNull(user)
    }

}