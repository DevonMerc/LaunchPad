<template>
    <div class = "card">
        <img src="../assets/PLACEHOLDER_LOGO.png"/>
        <p>{{ campaign.title }}</p>
        <p>Manged by {{ campaign.campaignManager }}</p>
        <p>{{ campaign.description }}</p>
        <p>${{ campaign.fundsRaised }}/${{ campaign.fundingGoal }} Currently raised</p>

        <p>Tags</p>
        <div v-for="tag in campaign.tags" :key="tag">
            <p>{{ tag }}</p>
        </div>
    </div> 

</template>

<script>
export default{
    props: ['campaign']
}
</script>

<style>

</style>