package me.test.first.spring.boot.jersey.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.stereotype.Component

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("/rest")
@Api(value = "/rest", description = "Jax-RS测试", tags = ["rest"])
class Rest {

    Rest() {
        println "================= new Rest() : @ " + new Date()
    }

    @GET
    @ApiOperation(value = "普通GET请求", notes = "你猜~")
    @ApiResponses([
            @ApiResponse(
                    code = 200,
                    message = "Nice!",
                    response = RestGetResp),
            @ApiResponse(
                    code = 400,
                    message = "Invalid ID supplied",
                    response = RestGetResp),
            @ApiResponse(code = 404,
                    message = "Pet not found",
                    response = RestGetResp)
    ])
    @Produces(MediaType.APPLICATION_JSON)
    Response get() {
        def data = [
                a: "aaa",
                b: "bbb",
                c: "ccc"
        ]
        return Response.status(Response.Status.OK).entity(data).build()

    }


}

class RestGetResp {
    String a
    String b
    String c
}

