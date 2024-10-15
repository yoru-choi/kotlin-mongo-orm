package jp.coconev.coconeapphub.apps.v1.userAndAuthService.presentation.controller


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Tag(name = UserOpenApi.TAG_NAME, description = UserOpenApi.TAG_DESCRIPTION)
@RestController
@Validated
@RequestMapping(" /users")
class UserController(
    private val userService: UserService,
) {
    @Operation(
        summary = UserOpenApi.GET_SUMMARY,
        description = UserOpenApi.GET_DESCRIPTION
    )
    @GetMapping("detail")
    fun getApp(
        @RequestAttribute("userId") @ObjectIdOnly userId: String,
    ): ResponseEntity<ApiSuccessResponseDto<UserServiceOutputDto>> {
        logger().info("userId: $userId")
        val outputService = userService.getUser(userId)
        val responseBody = ApiSuccessResponseDto(data = outputService)
        logger().info(responseBody.toString())
        return ResponseEntity(responseBody, HttpStatus.OK)
    }

    //test
    @PostMapping
    fun getAppddd(
        @RequestAttribute("userId") @ObjectIdOnly userId: String,
        @RequestParam(required = true) @ObjectIdOnly test: String,
        @RequestBody(required = true) @Validated requestBody: UpdateAppCollaboratorRequestBodyDto,
    ): ResponseEntity<ApiSuccessResponseDto<UserServiceOutputDto>> {
        requestBody.logger().info("userId: $userId")
        
        logger().info("userId: $userId")
        val outputService = userService.getUser(userId)
        val responseBody = ApiSuccessResponseDto(data = outputService)
        logger().info(responseBody.toString())

        return ResponseEntity(responseBody, HttpStatus.OK)
    }
}
