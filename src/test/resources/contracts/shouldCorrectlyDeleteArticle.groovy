package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should correctly delete article"

    request {
        method DELETE()
        url("/article/1")
    }

    response {
        status 200
    }
}