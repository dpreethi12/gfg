class Solution {
    public boolean dfs(List<List<Integer>> a,int s,boolean vis[],boolean st[]){
        vis[s] = true;
        st[s] = true;
        
        for(int v : a.get(s)){
            if(!vis[v]){
                if(dfs(a,v,vis,st)) return true;
            }else if(st[v]){
                return true;
            }
        }
        st[s] = false;
        return false;
    }
    public boolean isCyclic(int n, int[][] edges) {
        // code here
        boolean vis[] = new boolean[n];
        boolean st[] = new boolean[n];
        List<List<Integer>> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            a.add(new ArrayList<>());
        }
        for(int v[] : edges){
            int u = v[0];
            int x = v[1];
            a.get(u).add(x);
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(dfs(a,i,vis,st))
                    return true;
            } 
            
        }
        return false;
    }
}