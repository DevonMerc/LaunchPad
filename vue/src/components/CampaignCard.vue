<template>
    <div class = "card">
        <img src="../assets/PLACEHOLDER_LOGO.png"/>
        <div class="info">
        <p>{{ campaign.title }}</p>
        <p>Manged by {{ campaign.campaignManager }}</p>
        <p>{{ campaign.description }}</p>
        <p>${{ campaign.fundsRaised }}/${{ campaign.fundingGoal }} Currently raised</p>

        <!-- <p>Tags</p>
        <div class="tags" v-for="tag in campaign.tags" :key="tag">
            <p>{{ tag }}</p>
        </div> -->
    </div>
    </div> 

</template>

<script>
export default{
    props: ['campaign']
}
</script>

<style scoped>
body{
    padding: 0;
}
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 80%;
  height: auto;
  margin: 20px;
  position: relative;
  display: flex;
  flex-direction: row;

}
.card img{
    width: 50%;
    height: 50%;
}
/* .tags{
    display: flex;
    flex-direction: row;
} */
</style>