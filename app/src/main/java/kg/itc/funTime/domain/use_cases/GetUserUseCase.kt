package kg.itc.funTime.domain.use_cases

import kg.itc.funTime.data.repo.UserRepo
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepo: UserRepo) {

//    operator fun invoke(objectId : String): Single<UserEntity> {
//        return userRepo.getUserId(objectId)
//            .subscribeOn(Schedulers.io())
//            .map {
//                Log.d("List", it.toString())
//                it.first()
//            }
//            .map {
//                Log.d("List2", it.toString())
////                println(it)
////                userRepo.saveUsersToDb(it.map { it.toUserEntity() })
//                it.toUserEntity()
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//    }
}