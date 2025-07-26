package shaadi.com.assignment.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import shaadi.com.assignment.data.repository.PersonRepository
import shaadi.com.assignment.domain.Repository

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepoModule {

    @Binds
    abstract fun bindsRepository(personRepository: PersonRepository):Repository

}