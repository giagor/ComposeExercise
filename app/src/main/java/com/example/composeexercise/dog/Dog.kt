package com.example.composeexercise.dog

import com.example.composeexercise.R
import java.io.Serializable

data class Dog(val name: String, val image: Int, val introduction: String) : Serializable

// 数据的收集好累，555
// 数据来源：https://dogtime.com/dog-breeds/profiles
val dogList: List<Dog> = mutableListOf(
    Dog(
        "Aussiedoodle",
        R.drawable.aussiedoodle,
        "The Aussiedoodle is a mixed breed dog — a cross between the Australian Shepherd and Poodle dog breeds. Incredibly smart, playful, and loyal, these pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "Aussiedoodles go by several names, including Aussiepoo and Aussiepoodle. Despite their unfortunate status as a designer breed, you may find these mixed breed dogs in shelters and rescues. So please remember to adopt! Don’t shop!\n" +
                "These active dogs, often referred to as an “Einstein” breed for their smarts, do well in homes that can provide plenty of attention and exercise. The Aussiedoodle makes an excellent family dog, as long as smaller children know how to safely play with the pup. They are also incredible therapy dogs, given how quickly they bond to a specific human or two."
    ),
    Dog(
        "Basset Retriever",
        R.drawable.basset_retriever,
        "The Basset Retriever is a mixed breed dog–a cross between the Basset Hound and Golden Retriever dog breeds. Friendly, affectionate, and intelligent, these pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "You can find these mixed breed dogs in shelters and breed specific rescues, so remember to always adopt! Don’t shop if you’re looking to add one of these pups to your home!\n" +
                "The Basset Retriever is a great family dog with a mild-mannered disposition, a willingness to please, and a loving and devoted nature. The mixed breed is extra friendly and gets along well with children, although due their hunting heritage, they will require a high amount of exercise to stay healthy and happy. These dogs do best with active and busy families."
    ),
    Dog(
        "Corgi Inu",
        R.drawable.corgi_inu,
        "The Corgi Inu is a mixed breed dog — a cross between the Shiba Inu and the Corgi dog breeds. With the adorable looks of a fox, these vigilant, affable pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "Corgi Inus go by several names, including the Shiba Corgi or simply the Corgi Shiba Inu mix. Despite their status as a designer breed, you can find these mixed breed dogs in shelters and rescues. So remember to adopt! Don’t shop!\n" +
                "These adorable pups are incredibly alert, which makes them a great choice for anyone looking for a watch dog. This also makes them an excellent dog for singles living in active urban areas, seniors, or families with older children who know how to properly interact with dogs. If you’re looking for a highly trainable, independent companion, the Corgi Inu just might be the perfect dog for you!"
    ),
    Dog(
        "Dorkie",
        R.drawable.dorkie,
        "The Dorkie is a mixed breed dog — a cross between the Dachshund and Yorkshire Terrier. Laid-back and loyal, these pint-sized pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "Dorkies also go by the names Dorkie Terrier and Doxie Yorkie. Despite their unfortunate status as a designer breed, you can find these mixed breed pups in shelters and breed specific rescues, so remember to adopt! Don’t shop!\n" +
                "These adorable pups are not overly yappy and would make great companions for seniors living in apartments. While they’re well suited to small or single-person households, they’ll also thrive in larger family environments with older kids, as they demand quite a bit of attention. If you’re a traveler, this pup makes an easy travel companion and would love to tag along, wherever the road leads you."
    ),
    Dog(
        "Estrela Mountain Dog",
        R.drawable.estrela_mountain_dog,
        "The Estrela Mountain Dog is a purebred dog from the Estrela Mountains of Portugal. Courageous, protective, and loyal, these pups have some of the best qualities of most dog breeds around today.\n" +
                "\n" +
                "The Estrela Mountain Dog goes by several names, including Portuguese Shepherd and Cao da Serra da Estrela. These large, beautiful dogs live primarily in their homeland of Portugal, but you might still find them in local shelters and breed specific rescues. Remember to adopt! Don’t shop!\n" +
                "These adorable pups are quite large and suited for larger homes, preferably with yards to roam. They might not be well suited for apartment living. They’re loyal and protective, which makes them great for households of all sizes. If you want a loving companion who will guard your home and family and alert you to any potential dangers, then this beautiful pooch might be right for you!"
    ),
    Dog(
        "Bossie",
        R.drawable.bossie,
        "The Bossie is a mixed breed dog — a cross between the Boston Terrier and Australian Shepherd dog breeds. Medium in size, energetic, and loyal, these pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "The Bossie, also spelled Baussie, is an ideal pup. Despite their unfortunate status as a designer breed, you can find these mixed-breed dogs in shelters and breed specific rescues, so remember to adopt! Don’t shop!\n" +
                "These adorable pups make great additions to a large family or a single-person household. Just make sure they get plenty of attention and exercise. They should not be left alone in a yard because they may feel abandoned and become board and destructive. Read on to find out if this is the right dog for you!"
    ),
    Dog(
        "Goberian",
        R.drawable.goberian,
        "The Goberian is a mixed breed dog — a cross between the Golden Retriever and Siberian Husky dog breeds. Friendly, energetic, and smart, these pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "You may find these mixed breed dogs in shelters and rescues, so remember to always adopt! Don’t shop if you’re looking to add a Goberian to your home!\n" +
                "Goberians make for great family dogs. They are extremely friendly, renowned for their good temperament, and enjoy being around people. The devoted mixed breed is an excellent companion and will come to look on you and your family as their best friends. However, you’ll need to make sure you provide adequate exercise for your Goberian to ward off any antisocial habits — this is a dog that loves to go hiking, jogging, and taking extended trips to the local dog park. Such an active dog is not a good fit for an apartment dweller."
    ),
    Dog(
        "Great Pyrenees",
        R.drawable.great_pyrenees,
        "The Great Pyrenees dog breed‘s goal in life is to protect sheep, goats, livestock, people, children, grass, flowers, the moon, the lawn furniture, bird feeders, and any real or imaginary predators that may intrude on your personal space. Oh yeah, and to give, give, and give unconditional love.\n" +
                "\n" +
                "Even though these are purebred dogs, you may find them in the care of shelters or rescue groups. Remember to adopt! Don’t shop if you want to bring a dog home.\n" + "" +
                "Anyone who has seen this stunning white dog becomes enamored. What’s not to like? They have a strong build, a beautiful, thick coat, and they exude elegance and majesty. One look and you can see the intelligence and steady temperament that many seek in a good family dog."
    ),
    Dog(
        "Hokkaido",
        R.drawable.hokkaido,
        "The Hokkaido is a purebred dog from Japan. Intelligent, alert, and devoted to their families, these pooches have qualities that make them excellent companions.\n" +
                "\n" +
                "The Hokkaido goes several names, including Ainu-ken, Seta, and Ainu dog. In Japan specifically, their name is shortened to Do-ken. Though this breed is somewhat rare outside of Japan, you may still find these purebred dogs in shelters and rescues, so remember to adopt! Don’t shop!\n" +
                "These beautiful dogs can live in apartments and townhomes, as they are a medium-sized breed. But they are also quite active and would prefer a home with a yard or nearby park where they can walk and play. Hokkaidos get along in any household type, from single folks to large families. They also get along with children when raised with them or socialized properly at an early age. They’re alert to their surroundings and completely loyal, which might make them the perfect dog for you!"
    ),
    Dog(
        "Pomchi",
        R.drawable.pomchi,
        "The Pomchi is a mixed-breed dog — a cross between the Pomeranian and the Chihuahua dog breeds. Playful, devoted, and energetic, these small pups inherited some of the best qualities from both of their parents.\n" +
                "\n" +
                "Pomchis go by several names, including Pomahuahua, Chimeranian, Chi-Pom, and Pom-Chi. Despite their unfortunate status as a designer breed, you may find these mixed breed dogs in shelters and rescues. So remember to adopt! Don’t shop!\n" +
                "These adorable pups make excellent apartment dogs for active urban dwellers, and they also do well in small and single-person households. If you’re looking for a small, attention-loving dog with a lot of spunk, then the Pomchi may be the right dog for you!"
    )
)