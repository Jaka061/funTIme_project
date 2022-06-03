package kg.itc.funTime.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TypeApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserApi


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CompanyApi