package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should correctly update article"

    request {
        method PUT()
        url("/article/1?content=Content")
        headers {
            contentType(applicationJson())
        }
    }

    response {
        status 200
    }
}