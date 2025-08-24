package me.dio.controller.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.dio.domain.model.User;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto(
        @Schema(description = "User ID", example = "1")
        Long id,

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must be less than 100 characters")
        @Schema(description = "User's full name", example = "John Doe")
        String name,

        @Valid
        @NotNull(message = "Account is required")
        @Schema(description = "User's account information")
        AccountDto account,

        @Valid
        @NotNull(message = "Card is required")
        @Schema(description = "User's card information")
        CardDto card,

        @Valid
        @ArraySchema(schema = @Schema(description = "List of user features"))
        List<FeatureDto> features,

        @Valid
        @ArraySchema(schema = @Schema(description = "List of user news"))
        List<NewsDto> news
) {
    public UserDto(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(model.getCard()).map(CardDto::new).orElse(null),
                ofNullable(model.getFeatures()).orElse(emptyList()).stream()
                        .map(FeatureDto::new)
                        .collect(toList()),
                ofNullable(model.getNews()).orElse(emptyList()).stream()
                        .map(NewsDto::new)
                        .collect(toList())
        );
    }

    public User toModel() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
        user.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));
        user.setFeatures(ofNullable(this.features).orElse(emptyList()).stream()
                .map(FeatureDto::toModel)
                .collect(toList()));
        user.setNews(ofNullable(this.news).orElse(emptyList()).stream()
                .map(NewsDto::toModel)
                .collect(toList()));
        return user;
    }
}