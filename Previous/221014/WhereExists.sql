select ANIMAL_ID, NAME
    from ANIMAL_INS
    where exists (
        select ANIMAL_ID
            from ANIMAL_OUTS
            where ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
                && ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME
    )
    order by DATETIME asc
