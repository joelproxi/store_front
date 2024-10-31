package org.proxidev.productservice.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponseApi {
    private String message;
    private Integer errorCode;
    private String error;
    private String ErrorDescription;
    private Set<String> validationErrors;
    private Map<String, String> errors;
    private LocalDateTime timestamp;

    public ErrorResponseApi(String message, Integer errorCode, String error, String ErrorDescription, Set<String> validationErrors, Map<String, String> errors, LocalDateTime timestamp) {
        this.message = message;
        this.errorCode = errorCode;
        this.error = error;
        this.ErrorDescription = ErrorDescription;
        this.validationErrors = validationErrors;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public ErrorResponseApi() {
    }

    public static ErrorResponseApiBuilder builder() {
        return new ErrorResponseApiBuilder();
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorDescription() {
        return this.ErrorDescription;
    }

    public Set<String> getValidationErrors() {
        return this.validationErrors;
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setErrorDescription(String ErrorDescription) {
        this.ErrorDescription = ErrorDescription;
    }

    public void setValidationErrors(Set<String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ErrorResponseApi)) return false;
        final ErrorResponseApi other = (ErrorResponseApi) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$errorCode = this.getErrorCode();
        final Object other$errorCode = other.getErrorCode();
        if (this$errorCode == null ? other$errorCode != null : !this$errorCode.equals(other$errorCode)) return false;
        final Object this$error = this.getError();
        final Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error)) return false;
        final Object this$ErrorDescription = this.getErrorDescription();
        final Object other$ErrorDescription = other.getErrorDescription();
        if (this$ErrorDescription == null ? other$ErrorDescription != null : !this$ErrorDescription.equals(other$ErrorDescription))
            return false;
        final Object this$validationErrors = this.getValidationErrors();
        final Object other$validationErrors = other.getValidationErrors();
        if (this$validationErrors == null ? other$validationErrors != null : !this$validationErrors.equals(other$validationErrors))
            return false;
        final Object this$errors = this.getErrors();
        final Object other$errors = other.getErrors();
        if (this$errors == null ? other$errors != null : !this$errors.equals(other$errors)) return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponseApi;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $errorCode = this.getErrorCode();
        result = result * PRIME + ($errorCode == null ? 43 : $errorCode.hashCode());
        final Object $error = this.getError();
        result = result * PRIME + ($error == null ? 43 : $error.hashCode());
        final Object $ErrorDescription = this.getErrorDescription();
        result = result * PRIME + ($ErrorDescription == null ? 43 : $ErrorDescription.hashCode());
        final Object $validationErrors = this.getValidationErrors();
        result = result * PRIME + ($validationErrors == null ? 43 : $validationErrors.hashCode());
        final Object $errors = this.getErrors();
        result = result * PRIME + ($errors == null ? 43 : $errors.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        return result;
    }

    public String toString() {
        return "ErrorResponseApi(message=" + this.getMessage() + ", errorCode=" + this.getErrorCode() + ", error=" + this.getError() + ", ErrorDescription=" + this.getErrorDescription() + ", validationErrors=" + this.getValidationErrors() + ", errors=" + this.getErrors() + ", timestamp=" + this.getTimestamp() + ")";
    }

    public static class ErrorResponseApiBuilder {
        private String message;
        private Integer errorCode;
        private String error;
        private String ErrorDescription;
        private Set<String> validationErrors;
        private Map<String, String> errors;
        private LocalDateTime timestamp;

        ErrorResponseApiBuilder() {
        }

        public ErrorResponseApiBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseApiBuilder errorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorResponseApiBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ErrorResponseApiBuilder ErrorDescription(String ErrorDescription) {
            this.ErrorDescription = ErrorDescription;
            return this;
        }

        public ErrorResponseApiBuilder validationErrors(Set<String> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        public ErrorResponseApiBuilder errors(Map<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public ErrorResponseApiBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorResponseApi build() {
            return new ErrorResponseApi(this.message, this.errorCode, this.error, this.ErrorDescription, this.validationErrors, this.errors, this.timestamp);
        }

        public String toString() {
            return "ErrorResponseApi.ErrorResponseApiBuilder(message=" + this.message + ", errorCode=" + this.errorCode + ", error=" + this.error + ", ErrorDescription=" + this.ErrorDescription + ", validationErrors=" + this.validationErrors + ", errors=" + this.errors + ", timestamp=" + this.timestamp + ")";
        }
    }
}
