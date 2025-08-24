package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.dio.controller.dto.UserDto;
import me.dio.domain.model.User;
import me.dio.service.UserService;
import me.dio.service.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Endpoints for managing users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Get all users",
            description = "Retrieve a list of all registered users")
    @ApiResponse(responseCode = "200",
            description = "Successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserDto.class))))
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userMapper.toDtoList(userService.findAll()));
    }

    @Operation(summary = "Get user by ID",
            description = "Get a single user by their ID")
    @ApiResponse(responseCode = "200",
            description = "User found",
            content = @Content(schema = @Schema(implementation = UserDto.class)))
    @ApiResponse(responseCode = "404",
            description = "User not found")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userMapper.toDto(userService.findById(id)));
    }

    @Operation(summary = "Create a new user",
            description = "Register a new user in the system")
    @ApiResponse(responseCode = "201",
            description = "User created successfully",
            content = @Content(schema = @Schema(implementation = UserDto.class)))
    @ApiResponse(responseCode = "400",
            description = "Invalid input")
    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
        User createdUser = userService.create(userMapper.toModel(userDto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(userMapper.toDto(createdUser));
    }

    @Operation(summary = "Update an existing user",
            description = "Update user information")
    @ApiResponse(responseCode = "200",
            description = "User updated successfully",
            content = @Content(schema = @Schema(implementation = UserDto.class)))
    @ApiResponse(responseCode = "400",
            description = "Invalid input")
    @ApiResponse(responseCode = "404",
            description = "User not found")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id,
                                          @Valid @RequestBody UserDto userDto) {
        User user = userMapper.toModel(userDto);
        user.setId(id);
        return ResponseEntity.ok(userMapper.toDto(userService.update(id, user)));
    }

    @Operation(summary = "Delete a user",
            description = "Remove a user from the system")
    @ApiResponse(responseCode = "204",
            description = "User deleted successfully")
    @ApiResponse(responseCode = "400",
            description = "Invalid ID supplied")
    @ApiResponse(responseCode = "404",
            description = "User not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}