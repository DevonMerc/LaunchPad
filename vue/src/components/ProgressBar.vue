<template>
<div id="app">
  <div class="shell">
    <div class="bar" :style="{ width: (funding/goal)*100 + '%'}">
      <!-- <span>${{ funding }}</span> -->
    </div>
  </div>
</div>
</template>

<script>
export default{
    props: ['funding', 'goal']
}
</script>

<style scoped>
#app {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 3%;
  margin-bottom: 3%;
}

.shell {
  height: 100%;
  width: 100%;
  border: 1px solid #db8605;
  border-radius: 13px;
  padding: 3px;
}

.bar {
  background: linear-gradient(to right, #f5d314, #e0860f);
  height: 100%;
  border-radius: 9px;
}
</style>