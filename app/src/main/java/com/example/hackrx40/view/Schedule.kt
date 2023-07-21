package com.example.hackrx40.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.hackrx40.R
import com.example.hackrx40.databinding.FragmentScheduleBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class Schedule : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val services = resources.getStringArray(R.array.TypesofServices)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown1, services)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        val age = resources.getStringArray(R.array.AgeCategory)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.dropdown1, age)
        binding.autoCompleteTextView2.setAdapter(arrayAdapter2)

        val action = resources.getStringArray(R.array.SelectAction)
        val arrayAdapter3 = ArrayAdapter(requireContext(), R.layout.dropdown1, action)
        binding.autoCompleteTextView3.setAdapter(arrayAdapter3)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)


        binding.button1.setOnClickListener {
            openTimePicker()

        }

        val mycalender = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            mycalender.set(Calendar.YEAR, year)
            mycalender.set(Calendar.MONTH, month)
            mycalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(mycalender)
        }

        binding.button2.setOnClickListener {
            activity?.let { it1 ->
                DatePickerDialog(
                    it1, datePicker, mycalender.get(Calendar.YEAR), mycalender.get(Calendar.MONTH),
                    mycalender.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        }



        return binding.root
    }

    private fun updateLabel(mycalender: Calendar) {
        val myformat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        binding.button2.setText(sdf.format(mycalender.time))
    }


    private fun openTimePicker() {
        val isSystem24Hour = is24HourFormat(requireContext())
        val clockFormat = if (isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set Time")
            .build()
        picker.show(childFragmentManager, "TAG")
        picker.addOnPositiveButtonClickListener {

            val pickedHour: Int = picker.hour
            val pickedMinute: Int = picker.minute

            // check for single digit hour hour and minute
            // and update TextView accordingly
            val formattedTime: String = when {
                pickedHour > 12 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour - 12}:0${picker.minute} pm"
                    } else {
                        "${picker.hour - 12}:${picker.minute} pm"
                    }
                }

                pickedHour == 12 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour}:0${picker.minute} pm"
                    } else {
                        "${picker.hour}:${picker.minute} pm"
                    }
                }

                pickedHour == 0 -> {
                    if (pickedMinute < 10) {
                        "${picker.hour + 12}:0${picker.minute} am"
                    } else {
                        "${picker.hour + 12}:${picker.minute} am"
                    }
                }

                else -> {
                    if (pickedMinute < 10) {
                        "${picker.hour}:0${picker.minute} am"
                    } else {
                        "${picker.hour}:${picker.minute} am"
                    }
                }
            }

            // then update the preview TextView
            binding.button1.text = formattedTime
        }
    }

}