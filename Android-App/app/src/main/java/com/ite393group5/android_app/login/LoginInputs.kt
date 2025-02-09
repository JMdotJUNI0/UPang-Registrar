package com.ite393group5.android_app.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ite393group5.android_app.R
import com.ite393group5.android_app.common.EmailTextField
import com.ite393group5.android_app.common.NormalButton
import com.ite393group5.android_app.common.PasswordTextField
import com.ite393group5.android_app.theme.CustomTheme

@Composable
fun LoginInputs(
    loginState: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit,
) {

    Column(modifier = Modifier.fillMaxWidth()) {

        // Email or Mobile Number
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            onValueChange = onEmailChange,
            label = "username@phinmaed.com",
            isError = loginState.errorState.emailErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.emailErrorState.errorMessageStringResource),
            value = loginState.email
        )

        // Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            value = loginState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.login_password_label),
            isError = loginState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.passwordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Done

        )

        NormalButton(
            modifier = Modifier.padding(top = 24.dp).align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.login_button_text),
            onClick = onSubmit
        )
    }



}

@Preview(showBackground = true)
@Composable
fun LoginInputsPreview() {
   CustomTheme {
        LoginInputs(
            loginState = LoginState(),
            onEmailChange = {},
            onPasswordChange = {},
            onSubmit = {  }
        )

    }
}