package shaadi.com.assignment.data.mapper

import shaadi.com.assignment.data.local.entity.PersonEntity
import shaadi.com.assignment.data.network.models.PersonResultDTO
import shaadi.com.assignment.domain.Person

fun PersonResultDTO.toPerson(): PersonEntity {
    return PersonEntity(
        name="${this.name.first} ${this.name.last}",
        age=this.dob.age,
        image=this.picture.medium,
        uuid = this.login.uuid,
        address = "${this.location.city}, ${this.location.street.name}, ${this.location.state}, ${this.location.country}"
        )
}

fun PersonEntity.toPerson():Person {
    return Person(
        id=this.id,
        name = this.name,
        uuid = this.uuid,
        age = this.age,
        status = this.status,
        image = this.image,
        address = this.address
    )
}