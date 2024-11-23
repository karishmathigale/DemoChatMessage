package com.example.chatapp.domain.usecase

import com.example.chatapp.data.entity.SendMessageResponse
import com.example.chatapp.data.request.SendMessageRequest
import com.example.chatapp.domain.model.Message
import com.example.chatapp.domain.repository.MessengerRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.internal.matchers.apachecommons.ReflectionEquals


class MessageCommunicationUseCaseTest {

    /*@Mock
    lateinit var messengerRepository: MessengerRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

    }
    @Test
    fun shouldPassMessageRequestToRepositoryCorrectly() = runTest {
        //arrange
        val message = Message("Demo Message", false, "12345")
        val sut = MessageCommunicationUseCase(messengerRepository)

        //act
        sut.sendMessage(message)


        //assert
        val expectedMessage = SendMessageRequest(message.text,message.selfMessage,message.timeStamp)
        verify(messengerRepository, atLeastOnce()).sendMessage(expectedMessage)
    }

    @Test
    fun shouldReturnSuccessWhenRepositoryReturnsSuccess() = runTest {
        val message = Message("Demo Message", false, "12345")
        val sendMessageRequest = SendMessageRequest("Demo Message", false, "12345")
        val sut = MessageCommunicationUseCase(messengerRepository)

        Mockito.`when`(messengerRepository.sendMessage(sendMessageRequest))
            .thenReturn(SendMessageResponse.Success(message))

        //act
         val response = sut.sendMessage(message)


        //assert
        Assert.assertTrue(ReflectionEquals(SendMessageResponse.Success(message)).matches(response))
    }

    @Test
    fun shouldReturnFailureWhenRepositoryReturnsFailed() = runTest {
        val message = Message("Demo Message", false, "12345")
        val sendMessageRequest = SendMessageRequest("Demo Message", false, "12345")
        val sut = MessageCommunicationUseCase(messengerRepository)

        Mockito.`when`(messengerRepository.sendMessage(sendMessageRequest))
            .thenReturn(SendMessageResponse.Failure("error"))

        //act
        val response = sut.sendMessage(message)

        //assert
        Assert.assertTrue(ReflectionEquals(SendMessageResponse.Failure("error")).matches(response))
    }*/

}