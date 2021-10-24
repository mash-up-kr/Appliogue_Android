package com.anonymous.appilogue.features.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anonymous.appilogue.repository.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(private val notificationRepository: NotificationRepository) :
    ViewModel() {
    private val _notifications = MutableLiveData<List<NotificationListItem>>()
    val notifications: LiveData<List<NotificationListItem>> = _notifications

    fun fetchNotifications() {
        val notifications = mutableListOf<NotificationListItem>()
        notifications.add(NotificationListItem.Header("오늘"))
        notificationRepository.getNotification().forEach {
            notifications.add(NotificationListItem.NotificationItem(it))
        }
        notifications.add(NotificationListItem.Header("어제"))
        notificationRepository.getNotification().forEach {
            notifications.add(NotificationListItem.NotificationItem(it))
        }
        notifications.add(NotificationListItem.Header("1주일전"))
        notificationRepository.getNotification().forEach {
            notifications.add(NotificationListItem.NotificationItem(it))
        }
        notifications.add(NotificationListItem.Header("1년전"))
        notificationRepository.getNotification().forEach {
            notifications.add(NotificationListItem.NotificationItem(it))
        }
        _notifications.value = notifications
    }
}