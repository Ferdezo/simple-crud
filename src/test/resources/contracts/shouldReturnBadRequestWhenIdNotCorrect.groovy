package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return bad request when given id not correct"

    request {
        method GET()
        url("/article/x")
    }

    response {
        status 400
    }
}