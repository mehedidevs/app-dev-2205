package com.mehedi.esappdev2205.class21CustomRCV

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehedi.esappdev2205.R
import com.mehedi.esappdev2205.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PhotoEvent {


    var imageList = listOf<Image>(
        Image(
            "Woman Jumping Wearing Green Backpack",
            "https://images.pexels.com/photos/214574/pexels-photo-214574.jpeg"
        ),

        Image(
            "Photo of Person Paragliding Over Forest",
            "https://images.pexels.com/photos/2132116/pexels-photo-2132116.jpeg"
        ),
        Image(
            "Paragliders on Green Grass Field",
            "https://images.pexels.com/photos/13541584/pexels-photo-13541584.jpeg"
        ),
        Image(
            "People Paragliding in the Mountains",
            "https://images.pexels.com/photos/5015438/pexels-photo-5015438.jpeg"
        ),
        Image(
            "Man Holding Onto Parachute",
            "https://images.pexels.com/photos/2896411/pexels-photo-2896411.jpeg"
        ),
        Image(
            "Paragliding in tandem with a Red Parachute",
            "https://images.pexels.com/photos/11144295/pexels-photo-11144295.jpeg"
        )


    )

    lateinit var adapter: ImageAdapter

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        adapter = ImageAdapter(this@MainActivity)

        adapter.submitList(imageList)

        binding.imageRCV.adapter = adapter


    }

    override fun PhotoClickListener(image: Image) {

        val intent = Intent(this@MainActivity, ImageDetailsActivity2::class.java)
        intent.putExtra("img", image)
        //intent.putExtra("name", image.imageName)
        startActivity(intent)
    }
}