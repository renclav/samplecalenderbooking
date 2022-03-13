package com.renclav.samplecalendarbooking.domain.usecase

import com.renclav.samplecalendarbooking.data.repository.BookingsRepository
import com.renclav.samplecalendarbooking.domain.model.Booking
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Fetches current bookings linked to a userId
 * Note: this uses a Flow as real world app might observe this for changes,
 * instead of a being a one-off for this demo
 */
internal interface BookingSelectionCurrentBookingsUseCase {
    operator fun invoke(userId: String): Flow<List<Booking>>
}

internal class BookingSelectionCurrentBookingsUseCaseImpl @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
    private val bookingsRepository : BookingsRepository,
) : BookingSelectionCurrentBookingsUseCase {
    override fun invoke(userId: String): Flow<List<Booking>> {
        return flow<List<Booking>> {
            listOf<Booking>()
        }
            .catch {
                //Log exception and re-throw
                Timber.e(it)
                throw it
            }
            .flowOn(dispatchers.computation)
    }
}
