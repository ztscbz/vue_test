<template>
<!--  <article v-html="value" ></article>-->
  <div class="mavonEditor">
    <mavon-editor v-html="value"/>
  </div>
</template>

<script>
    export default {
        name: "Display",
        data() {
            return {
                value: "<h1><a id=\"one_0\"></a>one</h1>\n" +
                    "<pre><code class=\"lang-text\"> public List&lt;SignVo&gt; querySignByApp(String str) {\n" +
                    "        List&lt;SignVo&gt; signVos = mapper.querySign();\n" +
                    "        if(StringUtils.isNotEmpty(str)){\n" +
                    "            List&lt;SignVo&gt; collect = signVos.stream().filter(e -&gt; str.contains(e.getDictInfoCode())).collect(Collectors.toList());\n" +
                    "            getGis(collect);\n" +
                    "            return collect;\n" +
                    "        }\n" +
                    "        getGis(signVos);\n" +
                    "        return signVos;\n" +
                    "    }\n" +
                    "\n" +
                    "</code></pre>",
                defaultData: "preview"
            };
        }
    }
</script>

<style scoped>

</style>
