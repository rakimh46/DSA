// leetcode 721
class Solution {
    int[] par;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        par=new int[10001];
        for(int i=0;i<10001;i++){
            par[i]=i;
        }
        int id=0;
        
        Map<String,Integer> uqid=new HashMap<>(); 
        Map<String,String> uqn=new HashMap<>();
        
        for(List<String> acc: accounts){
            String name="";
            
            for(String email:acc){
                if(name==""){
                    name=email;
                    continue;
                }
                if(!uqn.containsKey(email)){
                    uqn.put(email,name);
                }
                if(!uqid.containsKey(email)){
                    uqid.put(email,id);
                    id++;
                }
                
                int u=uqid.get(acc.get(1));
                int v=uqid.get(email);
                
                union(u,v);
            }
        }
        
        Map<Integer,List<String>> pte=new HashMap<>(); 
        
        for(String email : uqn.keySet()){
            int idx=uqid.get(email);
            
            int pt=find(idx);
            
            if(pte.containsKey(pt)){
               pte.get(pt).add(email); 
            }else{
                pte.put(pt,new ArrayList<>());
                pte.get(pt).add(email); 
            }
        }
        
        List<List<String>> ans=new ArrayList<>();
        
        for(List<String> email : pte.values()){
            Collections.sort(email);
            
            String name=uqn.get(email.get(0));
            List<String> t=new ArrayList<>();
            t.add(name);
            for(String e:email){
                t.add(e);
            }
            ans.add(t);
        }
        return ans;
    }
    
    int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    
    void union(int u,int v){
        int p1=find(u);
        int p2=find(v);
        if(p1!=p2){
            par[p2]=p1;
        }
    }
}