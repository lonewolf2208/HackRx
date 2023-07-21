package com.example.hackrx40.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackrx40.R
import com.example.hackrx40.adapter.LeadsAdapter
import com.example.hackrx40.databinding.FragmentLeadsBinding
import com.example.hackrx40.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Leads : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding= FragmentLeadsBinding.inflate(inflater, container, false)
//        var data = ArrayList<Leads_data_model>()
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model ("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
//        data.add(Leads_data_model("Kunal Mehrotra","Google","CEO",R.drawable.bad_status,""))
        RetrofitClient.init().getLeads().enqueue(object : Callback<Leads_data_model?> {
            override fun onResponse(
                call: Call<Leads_data_model?>,
                response: Response<Leads_data_model?>
            ) {
                if(response.isSuccessful)
                {
                    var adapter= response.body()?.let { LeadsAdapter(it) }
                    var layout = LinearLayoutManager(
                        container?.context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter?.onClickListener(object : LeadsAdapter.ClickListener {
                        override fun OnClick(position: Int) {
                            var data = response.body()?.get(position)
                            var bundle = Bundle()
                            bundle.putParcelable("data", data)
//                            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_leads_to_userProfile,bundle)
                        }
                    })
                    binding.leadsRecyclerview.adapter=adapter
                    binding.leadsRecyclerview.layoutManager=layout
                }
            }

            override fun onFailure(call: Call<Leads_data_model?>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage.toString(), Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }


}