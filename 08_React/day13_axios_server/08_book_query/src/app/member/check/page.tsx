import { searchMember } from '@/service/member'
import { useQuery } from '@tanstack/react-query'
import React from 'react'

export default function MemberDetail({params : {id}} : {params : {id : string}}) {
  
    const { data: member, isLoading, error } = useQuery({
        queryKey: ["member", id],
        queryFn: () => searchMember(id),
    });

    if (isLoading) return <h1>Loading.....</h1>;
    if (error) return <h1>{(error as Error).message}</h1>;

    return (
    <div>
      
    </div>
  )
}
