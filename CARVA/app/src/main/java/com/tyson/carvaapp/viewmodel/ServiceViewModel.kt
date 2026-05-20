package com.tyson.carvaapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.tyson.carvaapp.model.Service

class ServiceViewModel : ViewModel() {

    companion object {

        val services = mutableStateListOf<Service>()
    }

    private var nextId = 1

    fun addService(service: Service) {

        services.add(
            service.copy(id = nextId++)
        )
    }

    fun deleteService(service: Service) {

        services.remove(service)
    }

    fun updateService(updated: Service) {

        val index =
            services.indexOfFirst {
                it.id == updated.id
            }

        if (index != -1) {

            services[index] = updated
        }
    }

    fun getServices(): List<Service> {

        return services
    }
}