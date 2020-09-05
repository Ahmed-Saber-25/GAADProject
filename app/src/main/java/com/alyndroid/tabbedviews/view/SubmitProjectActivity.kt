package com.alyndroid.tabbedviews.view

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import cn.pedant.SweetAlert.SweetAlertDialog
import com.alyndroid.tabbedviews.R
import com.alyndroid.tabbedviews.viewmodel.SubmitProjectViewModel
import kotlinx.android.synthetic.main.activity_submit_project.*


class SubmitProjectActivity : AppCompatActivity() {

    private lateinit var submitProjectViewModel: SubmitProjectViewModel
    var isValidFirstName = false
    var isValidLastName = false
    var isValidEmail = false
    var isValidGithubUrl = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_project)
        submitProjectViewModel = ViewModelProviders.of(this)[SubmitProjectViewModel::class.java]
        submitProjectViewModel.context = this
        validateInputOnUI()
        submit_BTN.setOnClickListener {
            if (isValidFirstName && isValidLastName && isValidEmail && isValidGithubUrl) {
                showAlertDialog(resources.getString(R.string.message))
            } else {

                Toast.makeText(this, "please,check your inputs and try later", Toast.LENGTH_LONG)
                    .show()
            }
        }

        close.setOnClickListener { finish() }


    }

    private fun validateInputOnUI() {

        first_name.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (first_name.text.toString().trim().isEmpty()) {
                    first_name.error = getString(R.string.enter_name)
                    isValidFirstName = false
                } else {
                    first_name.error = null
                    isValidFirstName = true
                }
            }
        }
        last_name.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                if (last_name.text.toString().trim().isEmpty()) {
                    last_name.error = getString(R.string.enter_name)
                    isValidLastName = false
                } else {
                    last_name.error = null
                    isValidLastName = true
                }
            }
        }

        email_address.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val adminMail = email_address.text.toString()
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(adminMail)
                        .matches()
                ) {
                    email_address.error = getString(R.string.invalid_email)
                    isValidEmail = false
                } else {
                    email_address.error = null
                    isValidEmail = true
                }
            }
        }
        project_link_on_github.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val projectLink = project_link_on_github.text.toString()
                if (!android.util.Patterns.WEB_URL.matcher(projectLink)
                        .matches() || !projectLink.contains("github", true)
                ) {
                    project_link_on_github.error = getString(R.string.invalid_github_url)
                    isValidGithubUrl = false
                } else {
                    project_link_on_github.error = null
                    isValidGithubUrl = true
                }
            }
        }
    }


    private fun showAlertDialog(message: String) {
        SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
            .setTitleText("Are you sure?")
            .setConfirmText("Yes")
            .setConfirmButtonBackgroundColor(Color.parseColor("#EC8706"))
            .setConfirmClickListener {
                submitProjectViewModel.submitProject(
                    email_address.text.toString(),
                    first_name.text.toString(),
                    last_name.text.toString(),
                    project_link_on_github.text.toString()
                )
            }
            .show()


    }

    fun submissionSuccessful() {
        SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
            .setTitleText("Submission Successful")
            .setConfirmText("OK")
            .setCustomImage(R.drawable.check_circle)
            .show()
    }

    fun submissionNotSuccessful() {
        SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
            .setTitleText("Submission Not Successful")
            .setConfirmText("OK")
            .setCustomImage(R.drawable.report_problem)
            .show()
    }
}